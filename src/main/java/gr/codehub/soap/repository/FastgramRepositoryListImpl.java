package gr.codehub.soap.repository;

import gr.codehub.soap.model.FastgramPost;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@Named("FastRepoList")
@RequestScoped
@NoArgsConstructor
public class FastgramRepositoryListImpl implements FastgramRepository {

    private static final List<FastgramPost> allPosts = new ArrayList<>();

    static {
        allPosts.add(createPost("Dina Reed", "15/4/2024", "I will be away from home for a month of great adventures!"));
        allPosts.add(createPost("Expensive Phones", "10/9/2024", "Our new expPhone 16 is 74.19% more interesting than version 15"));
        allPosts.add(createPost("Lenny Leonard", "6/8/2024", "I've set up a $19,000 GoFundMe to help me find a reason to spend money"));
        allPosts.add(createPost("Mandy Sandy", "7/7/2024", "I will surprise myself - Happy birthday Mandy!!!"));
        allPosts.add(createPost("Mary Max Risk", "2/5/2024", "Tomorrow I will attempt to catch lava with my bare hands!"));
        allPosts.add(createPost("Mary Max Risk", "3/5/2024", "Wish me luck guys - going for it now!!!"));
        allPosts.add(createPost("Mary Max Risk", "4/5/2024", "Tim here: Mary will be back with us soon"));
        allPosts.add(createPost("The Not Many Teeth Band", "13/2/2024", "Our new single 'Chewing Carpet' is on the floor now!"));
        allPosts.add(createPost("Neek The Grik", "22/3/2024", "My new pet coconut tree enjoys me talking to it"));
        allPosts.add(createPost("Tom Grammer", "1/1/2024", "I believe like burgers"));
        allPosts.add(createPost("Tom Grammer", "1/6/2024", "I've just confirmed that I like burgers"));
        allPosts.add(createPost("p1112", "3/2/2024", "Follow me to win toothbrushes for a year"));
        allPosts.add(createPost("bot819", "2/5/2024", "Tomorrow I will attempt to catch lava with my bare hands!"));
        allPosts.add(createPost("bot819", "22/3/2024", "My new pet coconut tree enjoys me talking to it"));
        allPosts.add(createPost("bot819", "22/3/2024", "My new pet coconut tree enjoys me talking to it"));
    }

    private static FastgramPost createPost(String user, String dateStr, String content) {
        Integer id = allPosts.size();
        Date date = null;
        try {
            date = new SimpleDateFormat("d/M/yyyy").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date: " + dateStr);
        }
        int views = (int) (Math.random() * 30) + 2;
        FastgramPost post = new FastgramPost(id, user, date, content, views, false);
        return post;
    }

    @Override
    public FastgramPost findPostById(int id) {
        Optional<FastgramPost> currencyOptional = allPosts.stream()
                // .filter(post -> id == post.getId() && !post.isDeleted())
                .filter(post -> !post.isDeleted())
                .filter(post -> id == post.getId())
                .findAny();
        if (currencyOptional.isPresent()) {
            return currencyOptional.get().increaseViews();
        }
        return null;
    }
    
    @Override
    public List<FastgramPost> findAll() {
        return allPosts;
    }

    @Override
    public FastgramPost findPostByMaxViews() {
        FastgramPost bestPost = null;
        for (FastgramPost post : allPosts) {
            if (!post.isDeleted() && 
                    (bestPost == null || post.getViews() > bestPost.getViews())) {
                bestPost = post;
            }
        }
        if (bestPost == null) {
            return null;
        }
        return bestPost.increaseViews();
    }

    @Override
    public List<FastgramPost> findPostsByUser(String user) {
        return allPosts.stream()
                .filter(post -> !post.isDeleted())
                .filter(post -> post.getUser().equalsIgnoreCase(user))
                .map(FastgramPost::increaseViews)
                .collect(Collectors.toList());
    }

    @Override
    public List<FastgramPost> findPostsByContent(String content) {
        final String contentLower = content.toLowerCase();
        return allPosts.stream()
                .filter(post -> !post.isDeleted())
                .filter(post -> post.getContent().toLowerCase().contains(contentLower))
                .map(FastgramPost::increaseViews)
                .collect(Collectors.toList());
    }

    @Override
    public FastgramPost savePost(FastgramPost post) {
        showRepositoryInfo();
        if (post.getId() == null) {
            post.setId(allPosts.size());
        }
        allPosts.add(post);
        return post;
    }

    private FastgramPost setDeletedPostById(int id, boolean deleted) {
        Optional<FastgramPost> postOptional = allPosts.stream()
                .filter(p -> p.getId() == id)
                .findAny();
        if (postOptional.isPresent()) {
            postOptional.get().setDeleted(deleted);
        }
        return postOptional.get();
    }
    
    @Override
    public FastgramPost deletePostById(int id) {
        return setDeletedPostById(id, true);
    }
    
    @Override
    public FastgramPost undeletePostById(int id) {
        return setDeletedPostById(id, false);
    }
    
    private static void showRepositoryInfo() {
        System.out.println("This is the FastgramRepositoryListImpl");
    }
}
