package net.hackertalk.model.channel;

// ref: https://discord.com/developers/docs/topics/permissions#permissions
@SuppressWarnings("PointlessBitwiseExpression")
public class Permission {

    public static final long CREATE_INVITE    = 1 << 0; // 创建邀请链接
    public static final long BAN_MEMBERS      = 1 << 1; // 永久踢人
    public static final long KICK_MEMBERS     = 1 << 2; // 踢人（可以再加入）
    public static final long ADMINISTRATOR    = 1 << 3; // 管理员（拥有全部权限）
    public static final long VIEW_CHANNEL     = 1 << 4; // 观看 channel 消息
    public static final long VIEW_AUDIT_LOG   = 1 << 5; // 查看审计日志

    public static final long SEND_MESSAGES    = 1 << 6; // 发送消息
    public static final long EMBED_LINKS      = 1 << 7; // 插入链接
    public static final long ATTACH_FILES     = 1 << 8; // 上传附件
    public static final long MENTION_EVERYONE = 1 << 9; // @所有人

    public static final long MUTE_MEMBERS     = 1 << 12; // 麦克风静音
    public static final long DEAFEN_MEMBERS   = 1 << 13; // 禁止某人收听
    public static final long MODERATE_MEMBERS = 1 << 14; // 设置禁言时间
    public static final long MANAGE_MESSAGES  = 1 << 10; // 屏蔽消息
    public static final long MANAGE_WEBHOOKS  = 1 << 11; // 管理 webhook
}
