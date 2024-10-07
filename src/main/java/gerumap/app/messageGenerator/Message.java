package gerumap.app.messageGenerator;

import jdk.jfr.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String content;
    private EventType event;
    private LocalDateTime time;

    public Message(String content, EventType type, LocalDateTime time) {
        this.content = content;
        this.event = type;
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append(event);
        sb.append("] [");
        sb.append(time.toString());
        sb.append("] ");
        sb.append(content);
        sb.append("\n");
        return sb.toString();
    }
}
