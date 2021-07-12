package cc.tianny.restful.model;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/12
 * Time: 8:14 下午
 * Description: No Description
 */
public class Message {
    private Long id;
    private String text;
    private String summary;
    private Calendar created = Calendar.getInstance();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }
}
