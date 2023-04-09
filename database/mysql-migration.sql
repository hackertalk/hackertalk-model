alter table "user" alter column verified type bool using verified::int::bool;

alter table post alter column blocked type bool using blocked::int::bool;
alter table post alter column deleted type bool using deleted::int::bool;

alter table comment alter column blocked type bool using blocked::int::bool;
alter table comment alter column deleted type bool using deleted::int::bool;

alter table channel alter column blocked type bool using blocked::int::bool;
alter table channel alter column deleted type bool using deleted::int::bool;
alter table channel_message alter column blocked type bool using blocked::int::bool;
alter table channel_message alter column deleted type bool using deleted::int::bool;

alter table feedback alter column pending type bool using pending::int::bool;

alter table atom_notification alter column unread type bool using unread::int::bool;
alter table comment_notification alter column unread type bool using unread::int::bool;
alter table follow_notification alter column unread type bool using unread::int::bool;
alter table like_notification alter column unread type bool using unread::int::bool;
alter table system_notification alter column unread type bool using unread::int::bool;

