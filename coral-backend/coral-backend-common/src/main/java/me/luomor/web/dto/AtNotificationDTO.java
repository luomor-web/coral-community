package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.ActivityDBO;
import me.luomor.dbo.NotificationDBO;

@Data
public class AtNotificationDTO extends NotificationDBO {

    private MomentDTO moment;
}
