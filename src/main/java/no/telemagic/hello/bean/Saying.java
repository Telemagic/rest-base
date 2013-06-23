package no.telemagic.hello.bean;

public class Saying {
    private final long id;
    private final String content;

    /**
     * @param id
     * @param content
     */
    public Saying(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
