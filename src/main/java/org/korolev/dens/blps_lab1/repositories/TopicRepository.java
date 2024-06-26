package org.korolev.dens.blps_lab1.repositories;

import org.korolev.dens.blps_lab1.entites.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Query(value = "select chapter.topics from Chapter chapter where chapter.id = :chapterId")
    List<Topic> getAllByChapter(@Param("chapterId") Integer chapterId);

    @Modifying
    @Query(value = "update Topic topic set topic.title = :title where topic.id = :topicId and topic.owner.login = :login")
    void updateTitle(@Param("topicId") Integer topicId, @Param("title") String title, @Param("login") String login);

    @Modifying
    @Query(value = "update Topic topic set topic.text = :text where topic.id = :topicId and topic.owner.login = :login")
    void updateText(@Param("topicId") Integer topicId, @Param("text") String text, @Param("login") String login);

}