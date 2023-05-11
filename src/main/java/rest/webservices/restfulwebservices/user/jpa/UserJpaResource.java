package rest.webservices.restfulwebservices.user.jpa;

import org.springframework.http.MediaType;
import rest.webservices.restfulwebservices.exception.PostNotFoundException;
import rest.webservices.restfulwebservices.exception.UserNotFoundException;
import rest.webservices.restfulwebservices.user.Post;
import rest.webservices.restfulwebservices.user.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

	private final UserRepository userRepository;

	private final PostRepository postRepository;

	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		this.userRepository = repository;
		this.postRepository = postRepository;
	}

	// GET /users by default in xml
	@GetMapping(value = "/jpa/users", produces = MediaType.APPLICATION_XML_VALUE)
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// GET /users in json
	@GetMapping(value = "/jpa/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsersJson() {
		return userRepository.findAll();
	}

	// GET /users
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id) {
		final Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new UserNotFoundException("id:" + id);
		}
		User user = userOptional.get();

		EntityModel<User> userEntityModel = EntityModel.of(user);
		WebMvcLinkBuilder linkBuilder =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		userEntityModel.add(linkBuilder.withRel("all-users"));
		return userEntityModel;
	}

	//POST /users
	@PostMapping("/jpa/users")
	public void createUser(@Valid @RequestBody User user) {
		userRepository.save(user);
	}

	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}

	@GetMapping("jpa/users/{id}/posts")
	public List<Post> retreivePostsForUser(@PathVariable Integer id) {
		final Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new UserNotFoundException("id:" + id);
		}
		User user = userOptional.get();

		return user.getPosts();
	}

	@DeleteMapping("jpa/users/{userId}/posts/{postId}")
	public void deletePostForUser(@PathVariable Integer userId, @PathVariable Integer postId) {
		final Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isEmpty()){
			throw new UserNotFoundException("id:" + userId);
		}
		User user = userOptional.get();

		final Optional<Post> requiredPost = user.getPosts().stream().filter(post -> postId.equals(post.getId())).findFirst();

		if (requiredPost.isEmpty()){
			throw new PostNotFoundException("id:" + postId);
		}
		Post post = requiredPost.get();

		postRepository.deleteById(post.getId());
	}

	@PostMapping("jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable Integer id,
													@Valid @RequestBody Post post) {
		final Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new UserNotFoundException("id:" + id);
		}
		User user = userOptional.get();

		post.setUser(user);

		final Post savedPost = postRepository.save(post);

		//Add location header
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
