create type admin_identity_type as enum ('EMAIL');
alter type admin_identity_type owner to postgres;

create type admin_status as enum ('NORMAL', 'INACTIVE', 'LOCKED', 'DISABLED');
alter type admin_status owner to postgres;

create type blocked_type as enum ('SPAM', 'EXPLICIT', 'HATE_SPEECH', 'NOT_SUITABLE', 'COMMERCIAL_CONTENT');
alter type blocked_type owner to postgres;

create type channel_action_type as enum ('CHANNEL_CREATE', 'CHANNEL_UPDATE', 'CHANNEL_DELETE', 'MEMBER_MUTE', 'MEMBER_UNMUTE', 'MEMBER_BAN_CREATE', 'MEMBER_BAN_DELETE');
alter type channel_action_type owner to postgres;

create type channel_message_content_type as enum ('TEXT', 'IMAGE', 'MARKDOWN');
alter type channel_message_content_type owner to postgres;

create type chat_message_content_type as enum ('TEXT', 'IMAGE', 'MARKDOWN');
alter type chat_message_content_type owner to postgres;

create type feedback_type as enum ('BUG', 'EXPERIENCE');
alter type feedback_type owner to postgres;

create type gender as enum ('MALE', 'FEMALE', 'OTHER');
alter type gender owner to postgres;

create type message_type as enum ('EMPTY', 'COMMENT', 'BLOCKED_REASON');
alter type message_type owner to postgres;

create type recipient_type as enum ('USER', 'GROUP');
alter type recipient_type owner to postgres;

create type report_type as enum ('UNWELCOME_COMMERCIAL_OR_SPAM', 'ABUSE_OR_HATE_OR_VIOLENT', 'NOT_SUITABLE_FOR_DISCUSSION', 'PORNOGRAPHIC_OR_EXPLICIT', 'HARASSMENT_OR_BULLYING', 'OTHER');
alter type report_type owner to postgres;

create type social_media_platform as enum ('FACEBOOK', 'GITHUB', 'INSTAGRAM', 'LINKEDIN', 'QQ', 'TWITTER', 'WECHAT', 'WEIBO', 'YOUTUBE');
alter type social_media_platform owner to postgres;

create type target_type as enum ('USER', 'POST', 'COMMENT', 'MESSAGE', 'CHANNEL_MESSAGE');
alter type target_type owner to postgres;

create type user_action as enum ('LIKE', 'FAVORITE', 'COMMENT');
alter type user_action owner to postgres;

create type user_identity_type as enum ('PHONE', 'EMAIL', 'WECHAT', 'QQ', 'WEIBO', 'FACEBOOK', 'TWITTER', 'GITHUB', 'GOOGLE', 'APPLE');
alter type user_identity_type owner to postgres;

create type user_status as enum ('NORMAL', 'INACTIVE', 'LOCKED', 'DISABLED');
alter type user_status owner to postgres;
