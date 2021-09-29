package com.ibrahim.sr.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    //serializable sinifi degiskenlerin degerlerinin tiplerinin vs kaybolmamasini sagliyor
    //orn dosyaya degerler yazdik. okurken bu degelerin tipleri kayboluyor. serializable interface i bunu engelliyor

    private String notificationId;
    private Date createdAt;
    private Boolean Seen;
    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSeen() {
        return Seen;
    }

    public void setSeen(Boolean seen) {
        Seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdAt=" + createdAt +
                ", Seen=" + Seen +
                ", message='" + message + '\'' +
                '}';
    }
}
