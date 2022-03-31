
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */
import java.util.PriorityQueue;

// @lc code=start
class Twitter {
    HashMap<Integer, HashSet<Integer>> followees;
    int tweetCount;
    HashMap<Integer, Deque<Tweet>> tweets;

    class Tweet {
        int id, rank;

        Tweet(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }
    }

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
        tweetCount = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, tweetCount);
        Deque<Tweet> userTweets = tweets.getOrDefault(userId, new LinkedList<>());
        userTweets.offer(newTweet);
        if (userTweets.size() > 10) {
            userTweets.remove();
        }
        tweets.put(userId, userTweets);
        tweetCount++;
    }

    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followeeList = new HashSet<>(followees.getOrDefault(userId, new HashSet<>()));
        followeeList.add(userId);
        PriorityQueue<Tweet> top10 = new PriorityQueue<>((x, y) -> x.rank - y.rank);
        for (Integer followee : followeeList) {
            Deque<Tweet> followeeTweets = new LinkedList<>(tweets.getOrDefault(followee, new LinkedList<>()));
            while (!followeeTweets.isEmpty()) {
                if (!top10.isEmpty()) {
                    Tweet tweet = followeeTweets.poll();
                    top10.offer(tweet);
                    if (top10.size() > 10) {
                        top10.poll();
                    }
                } else {
                    top10.offer(followeeTweets.poll());
                }

            }
        }
        List<Integer> result = new ArrayList<>();
        while (!top10.isEmpty()) {
            int Id = top10.poll().id;
            result.add(Id);
        }
        Collections.reverse(result);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followeeList = followees.getOrDefault(followerId, new HashSet<>());
        followeeList.add(followeeId);
        followees.put(followerId, followeeList);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeList = followees.getOrDefault(followeeId, new HashSet<>());
        followeeList.remove(followeeId);
        followees.put(followerId, followeeList);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end
