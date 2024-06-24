package Java_Junior.lesson4.hw;

import jakarta.persistence.*;

@Entity
@Table(name = "PostComment")
public class PostComment {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", title='" + title + '\'' +
      ", post_id=" + post_id +
                '}';
    }
}
