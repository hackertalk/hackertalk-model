alter table application."user" alter column verified type boolean using verified::int::boolean;

alter table application.post alter column blocked type boolean using blocked::int::boolean;
alter table application.post alter column deleted type boolean using deleted::int::boolean;

alter table application.comment alter column blocked type boolean using blocked::int::boolean;
alter table application.comment alter column deleted type boolean using deleted::int::boolean;

alter table application.channel alter column blocked type boolean using blocked::int::boolean;
alter table application.channel alter column deleted type boolean using deleted::int::boolean;
alter table application.channel_message alter column blocked type boolean using blocked::int::boolean;
alter table application.channel_message alter column deleted type boolean using deleted::int::boolean;

alter table application.feedback alter column pending type boolean using pending::int::boolean;

alter table application.atom_notification alter column unread type boolean using unread::int::boolean;
alter table application.comment_notification alter column unread type boolean using unread::int::boolean;
alter table application.follow_notification alter column unread type boolean using unread::int::boolean;
alter table application.like_notification alter column unread type boolean using unread::int::boolean;
alter table application.system_notification alter column unread type boolean using unread::int::boolean;

alter table application.chat alter column deleted type boolean using deleted::int::boolean;
