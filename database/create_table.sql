create table admin
(
    id         bigint                   not null
        primary key,
    email      varchar(64)              not null,
    status     application.admin_status not null,
    created_at bigint                   not null,
    updated_at bigint                   not null
);
alter table admin owner to postgres;
grant select on admin to hackertalk_reader_role;
grant delete, insert, select, update on admin to hackertalk_writer_role;


create table admin_identity
(
    identity_type      application.admin_identity_type not null,
    identifier         varchar(32)                     not null,
    admin_id           bigint                          not null,
    credential         varchar(256)                    not null,
    refresh_credential varchar(256)                    not null,
    created_at         bigint                          not null,
    updated_at         bigint                          not null,
    constraint admin_identity_pk
        primary key (identity_type, identifier)
);
alter table admin_identity owner to postgres;
grant select on admin_identity to hackertalk_reader_role;
grant delete, insert, select, update on admin_identity to hackertalk_writer_role;


create table blocked_reason
(
    id          bigint                   not null
        primary key,
    from_id     bigint                   not null,
    type        application.blocked_type not null,
    target_id   bigint                   not null,
    target_type application.target_type  not null,
    created_at  bigint                   not null
);
alter table blocked_reason owner to postgres;
grant select on blocked_reason to hackertalk_reader_role;
grant delete, insert, select, update on blocked_reason to hackertalk_writer_role;


create table channel
(
    id          bigint       not null
        primary key,
    from_id     bigint       not null
        constraint channel_user_id_fk
            references "user",
    icon        varchar(64)  not null,
    name        varchar(64)  not null,
    description varchar(256) not null,
    permissions bigint       not null,
    max_members integer      not null,
    deleted     boolean      not null,
    blocked     boolean      not null,
    created_at  bigint       not null,
    updated_at  bigint       not null,
    deleted_at  bigint       not null
);

alter table channel owner to postgres;
grant select on channel to hackertalk_reader_role;
grant delete, insert, select, update on channel to hackertalk_writer_role;


create table channel_audit_log
(
    id          bigint                          not null
        primary key,
    channel_id  bigint                          not null
        constraint "channel_audit_log-channel_fkey"
            references channel,
    from_id     bigint                          not null
        constraint "channel_audit_log-user_fkey"
            references "user",
    target_id   bigint                          not null,
    action_type application.channel_action_type not null,
    reason      varchar(512)                    not null,
    created_at  bigint                          not null
);
alter table channel_audit_log owner to postgres;
grant select on channel_audit_log to hackertalk_reader_role;
grant delete, insert, select, update on channel_audit_log to hackertalk_writer_role;


create table channel_ban
(
    id         bigint not null
        primary key,
    channel_id bigint not null
        constraint "channel_ban-channel_fkey"
            references channel,
    user_id    bigint not null
        constraint "channel_ban-user_fkey"
            references "user",
    created_at bigint not null,
    constraint channel_ban_ukey
        unique (channel_id, user_id)
);
alter table channel_ban owner to postgres;
grant select on channel_ban to hackertalk_reader_role;
grant delete, insert, select, update on channel_ban to hackertalk_writer_role;


create table channel_member
(
    id          bigint not null
        primary key,
    channel_id  bigint not null
        constraint "channel_member-channel_fkey"
            references channel,
    user_id     bigint not null
        constraint "channel_member-user_fkey"
            references "user",
    permissions bigint not null,
    muted_until bigint not null,
    created_at  bigint not null,
    constraint channel_member_ukey
        unique (channel_id, user_id)
);
alter table channel_member owner to postgres;
grant select on channel_member to hackertalk_reader_role;
grant delete, insert, select, update on channel_member to hackertalk_writer_role;


create table channel_member_role
(
    channel_id bigint not null
        constraint "channel_member_role-channel_fkey"
            references channel,
    user_id    bigint not null
        constraint "channel_member_role-user_fkey"
            references "user",
    role_id    bigint not null
        constraint "channel_member_role-channel_role_fkey"
            references channel_role,
    created_at bigint not null,
    primary key (channel_id, user_id, role_id)
);

alter table channel_member_role owner to postgres;
grant select on channel_member_role to hackertalk_reader_role;
grant delete, insert, select, update on channel_member_role to hackertalk_writer_role;


create table channel_message
(
    id           bigint                                   not null
        primary key,
    channel_id   bigint                                   not null
        constraint "channel_message-channel_fkey"
            references channel,
    from_id      bigint                                   not null
        constraint "channel_message-user_fkey"
            references "user",
    content      varchar(2048)                            not null,
    content_type application.channel_message_content_type not null,
    deleted      boolean                                  not null,
    blocked      boolean                                  not null,
    created_at   bigint                                   not null,
    updated_at   bigint                                   not null,
    deleted_at   bigint                                   not null
);
alter table channel_message owner to postgres;
grant select on channel_message to hackertalk_reader_role;
grant delete, insert, select, update on channel_message to hackertalk_writer_role;


create table channel_role
(
    id          bigint      not null
        primary key,
    channel_id  bigint      not null
        constraint "channel_role-channel_fkey"
            references channel,
    name        varchar(64) not null,
    permissions bigint      not null,
    created_at  bigint      not null
);
alter table channel_role owner to postgres;
grant select on channel_role to hackertalk_reader_role;
grant delete, insert, select, update on channel_role to hackertalk_writer_role;


create table channel_subscription
(
    id         bigint not null
        primary key,
    channel_id bigint not null
        constraint channel_subscription_channel_fkey
            references channel,
    session_id uuid   not null,
    user_id    bigint not null
        constraint channel_subscription_user_fkey
            references "user",
    created_at bigint not null
);
alter table channel_subscription owner to postgres;
grant select on channel_subscription to hackertalk_reader_role;
grant delete, insert, select, update on channel_subscription to hackertalk_writer_role;


create table chat
(
    id                   bigint                     not null
        primary key,
    sender_id            bigint                     not null
        constraint chat_sender_fkey
            references "user",
    recipient_id         bigint                     not null,
    recipient_type       application.recipient_type not null,
    deleted              boolean                    not null,
    last_seen_message_id bigint                     not null,
    created_at           bigint                     not null,
    updated_at           bigint                     not null,
    constraint chat_ukey
        unique (sender_id, recipient_id, recipient_type)
);
alter table chat owner to postgres;
grant select on chat to hackertalk_reader_role;
grant delete, insert, select, update on chat to hackertalk_writer_role;


create table chat_message
(
    id             bigint                                not null
        primary key,
    sender_id      bigint                                not null
        constraint chat_message_user_fkey
            references "user",
    recipient_id   bigint                                not null,
    recipient_type application.recipient_type            not null,
    content        varchar(2048)                         not null,
    content_type   application.chat_message_content_type not null,
    created_at     bigint                                not null
);
alter table chat_message owner to postgres;
grant select on chat_message to hackertalk_reader_role;
grant delete, insert, select, update on chat_message to hackertalk_writer_role;


create table comment
(
    id         bigint        not null
        primary key,
    post_id    bigint        not null
        constraint "comment-post_fkey"
            references post,
    from_id    bigint        not null
        constraint "comment-user_fkey"
            references "user",
    parent_id  bigint        not null,
    lang       varchar(6)    not null,
    content    varchar(2048) not null,
    blocked    boolean       not null,
    deleted    boolean       not null,
    created_at bigint        not null,
    updated_at bigint        not null
);
alter table comment owner to postgres;
grant select on comment to hackertalk_reader_role;
grant delete, insert, select, update on comment to hackertalk_writer_role;


create table comment_like
(
    comment_id bigint not null,
    from_id    bigint not null,
    created_at bigint not null,
    primary key (comment_id, from_id)
);
alter table comment_like owner to postgres;
grant select on comment_like to hackertalk_reader_role;
grant delete, insert, select, update on comment_like to hackertalk_writer_role;


create table comment_notification
(
    id           bigint                   not null
        primary key,
    from_id      bigint                   not null
        constraint comment_notification_from_fkey
            references "user",
    to_id        bigint                   not null
        constraint comment_notification_to_fkey
            references "user",
    target_id    bigint                   not null,
    target_type  application.target_type  not null,
    message_id   bigint                   not null,
    message_type application.message_type not null,
    unread       boolean                  not null,
    created_at   bigint                   not null,
    constraint comment_notification_ukey
        unique (from_id, to_id, message_id, message_type)
);
alter table comment_notification owner to postgres;
grant select on comment_notification to hackertalk_reader_role;
grant delete, insert, select, update on comment_notification to hackertalk_writer_role;


create table draft
(
    id         bigint       not null
        primary key,
    from_id    bigint       not null
        constraint "draft-user_fkey"
            references "user",
    published  boolean      not null,
    title      varchar(128) not null,
    content    text         not null,
    created_at bigint       not null,
    updated_at bigint       not null
);
alter table draft owner to postgres;
grant select on draft to hackertalk_reader_role;
grant delete, insert, select, update on draft to hackertalk_writer_role;


create table draft_tag
(
    draft_id bigint not null
        constraint "draft_tag-draft_fkey"
            references draft,
    tag_id   bigint not null,
    primary key (draft_id, tag_id)
);
alter table draft_tag owner to postgres;
grant select on draft_tag to hackertalk_reader_role;
grant delete, insert, select, update on draft_tag to hackertalk_writer_role;


create table feedback
(
    id         bigint                    not null
        primary key,
    from_id    bigint                    not null
        constraint "feedback-user_fkey"
            references "user",
    type       application.feedback_type not null,
    content    varchar(2048)             not null,
    pending    boolean                   not null,
    created_at bigint                    not null,
    updated_at bigint                    not null
);
alter table feedback owner to postgres;
grant select on feedback to hackertalk_reader_role;
grant delete, insert, select, update on feedback to hackertalk_writer_role;


create table follow_notification
(
    id         bigint  not null
        primary key,
    from_id    bigint  not null
        constraint follow_notification_user_id_fk
            references "user",
    to_id      bigint  not null
        constraint follow_notification_user_id_fk2
            references "user",
    unread     boolean not null,
    created_at bigint  not null,
    constraint follow_notification_ukey
        unique (from_id, to_id)
);
alter table follow_notification owner to postgres;
grant select on follow_notification to hackertalk_reader_role;
grant delete, insert, select, update on follow_notification to hackertalk_writer_role;


create table internal_test_user
(
    user_id    bigint not null
        constraint internal_test_user_user_fk
            references "user",
    created_at bigint not null
);
alter table internal_test_user owner to postgres;
create index fki_internal_test_user_user_fk on internal_test_user (user_id);
grant select on internal_test_user to hackertalk_reader_role;
grant delete, insert, select, update on internal_test_user to hackertalk_writer_role;


create table like_notification
(
    id          bigint                  not null
        primary key,
    from_id     bigint                  not null
        constraint like_notification_from_fkey
            references "user",
    to_id       bigint                  not null
        constraint like_notification_to_fkey
            references "user",
    target_id   bigint                  not null,
    target_type application.target_type not null,
    action      application.user_action not null,
    unread      boolean                 not null,
    created_at  bigint                  not null,
    constraint like_notification_ukey
        unique (from_id, target_id, target_type, action)
);
alter table like_notification owner to postgres;
grant select on like_notification to hackertalk_reader_role;
grant delete, insert, select, update on like_notification to hackertalk_writer_role;


create table post
(
    id         bigint       not null
        primary key,
    from_id    bigint       not null
        constraint post_user_fkey
            references "user",
    lang       varchar(6)   not null,
    title      varchar(128) not null,
    content    text         not null,
    ranks      bigint       not null,
    deleted    boolean      not null,
    blocked    boolean      not null,
    created_at bigint       not null,
    updated_at bigint       not null,
    deleted_at bigint       not null
);
alter table post owner to postgres;
create index post_user_idx on post (from_id, deleted, blocked, id);
create index post_time_idx on post (id, deleted, blocked);
create index post_rank_idx on post (ranks, deleted, blocked, id);
grant select on post to hackertalk_reader_role;
grant delete, insert, select, update on post to hackertalk_writer_role;


create table post_favorite
(
    post_id    bigint not null
        constraint post_favorite_post_fkey
            references post,
    from_id    bigint not null
        constraint post_favorite_user_fkey
            references "user",
    created_at bigint not null,
    primary key (post_id, from_id)
);
alter table post_favorite owner to postgres;
grant select on post_favorite to hackertalk_reader_role;
grant delete, insert, select, update on post_favorite to hackertalk_writer_role;


create table post_impression
(
    id         bigint not null
        primary key,
    post_id    bigint not null
        constraint post_impression_fkey
            references post,
    from_id    bigint not null,
    created_at bigint not null
);
alter table post_impression owner to postgres;
grant select on post_impression to hackertalk_reader_role;
grant delete, insert, select, update on post_impression to hackertalk_writer_role;


create table post_like
(
    post_id    bigint not null
        constraint post_like_post_fkey
            references post,
    from_id    bigint not null
        constraint post_like_user_fkey
            references "user",
    created_at bigint not null,
    primary key (from_id, post_id)
);
alter table post_like owner to postgres;
grant select on post_like to hackertalk_reader_role;
grant delete, insert, select, update on post_like to hackertalk_writer_role;


create table post_tag
(
    post_id bigint not null
        constraint post_tag_post_fkey
            references post,
    tag_id  bigint not null
        constraint post_tag_tag_fkey
            references tag,
    primary key (post_id, tag_id)
);
alter table post_tag owner to postgres;
grant select on post_tag to hackertalk_reader_role;
grant delete, insert, select, update on post_tag to hackertalk_writer_role;


create table report
(
    id          bigint                  not null
        primary key,
    from_id     bigint                  not null
        constraint report_from_fkey
            references "user",
    target_id   bigint                  not null,
    target_type application.target_type not null,
    report_type application.report_type not null,
    content     varchar(2048)           not null,
    pending     boolean                 not null,
    created_at  bigint                  not null,
    updated_at  bigint                  not null,
    constraint report_ukey
        unique (from_id, target_id, target_type)
);
alter table report owner to postgres;
grant select on report to hackertalk_reader_role;
grant delete, insert, select, update on report to hackertalk_writer_role;


create table system_notification
(
    id           bigint                   not null
        primary key,
    from_id      bigint                   not null,
    to_id        bigint                   not null
        constraint system_notification_to_fkey
            references "user",
    target_id    bigint                   not null,
    target_type  application.target_type  not null,
    message_id   bigint                   not null,
    message_type application.message_type not null,
    unread       boolean                  not null,
    created_at   bigint                   not null,
    constraint system_notification_ukey
        unique (from_id, message_id, message_type)
);
alter table system_notification owner to postgres;
grant select on system_notification to hackertalk_reader_role;
grant delete, insert, select, update on system_notification to hackertalk_writer_role;


create table tag
(
    id         bigint       not null
        primary key,
    tag_name   varchar(35)  not null
        constraint tag_ukey
            unique,
    image      varchar(32)  not null,
    excerpt    varchar(256) not null,
    created_at bigint       not null
);
alter table tag owner to postgres;
grant select on tag to hackertalk_reader_role;
grant delete, insert, select, update on tag to hackertalk_writer_role;


create table tag_not_found
(
    id       bigint      not null
        primary key,
    tag_name varchar(35) not null
);
alter table tag_not_found owner to postgres;
grant select on tag_not_found to hackertalk_reader_role;
grant delete, insert, select, update on tag_not_found to hackertalk_writer_role;


create table tag_synonym
(
    tag_id  bigint      not null
        constraint tag_synonym_fkey
            references tag,
    synonym varchar(32) not null,
    primary key (tag_id, synonym)
);
alter table tag_synonym owner to postgres;
grant select on tag_synonym to hackertalk_reader_role;
grant delete, insert, select, update on tag_synonym to hackertalk_writer_role;


create table topic
(
    id          bigint       not null
        primary key,
    topic_name  varchar(32)  not null
        constraint topic_ukey
            unique,
    title       varchar(64)  not null,
    image       varchar(64)  not null,
    description varchar(256) not null,
    ranks       bigint       not null,
    created_at  bigint       not null
);
alter table topic owner to postgres;
grant select on topic to hackertalk_reader_role;
grant delete, insert, select, update on topic to hackertalk_writer_role;


create table topic_tag
(
    topic_id bigint not null
        constraint topic_tag_topic_fkey
            references topic,
    tag_id   bigint not null
        constraint topic_tag_tag_fkey
            references tag,
    primary key (topic_id, tag_id)
);
alter table topic_tag owner to postgres;
grant select on topic_tag to hackertalk_reader_role;
grant delete, insert, select, update on topic_tag to hackertalk_writer_role;


create table "user"
(
    id         bigint                  not null
        primary key,
    nickname   varchar(64)             not null,
    username   varchar(16)             not null,
    bio        varchar(256)            not null,
    avatar     varchar(32)             not null,
    cover      varchar(32)             not null,
    gender     application.gender      not null,
    website    varchar(64)             not null,
    location   varchar(32)             not null,
    birthday   varchar(10)             not null,
    verified   boolean                 not null,
    status     application.user_status not null,
    created_at bigint                  not null,
    updated_at bigint                  not null
);
alter table "user" owner to postgres;
grant select on "user" to hackertalk_reader_role;
grant delete, insert, select, update on "user" to hackertalk_writer_role;


create table user_access_history
(
    id         bigint      not null
        primary key,
    user_id    bigint      not null
        constraint user_access_history_user_fk
            references "user",
    ip         varchar(63) not null,
    user_agent text        not null,
    created_at bigint      not null
);
alter table user_access_history owner to postgres;
grant select on user_access_history to hackertalk_reader_role;
grant delete, insert, select, update on user_access_history to hackertalk_writer_role;


create table user_activity
(
    id         bigint not null
        primary key,
    user_id    bigint not null
        constraint user_activity_user_fk
            references "user",
    created_at bigint not null
);
alter table user_activity owner to postgres;
grant select on user_activity to hackertalk_reader_role;
grant delete, insert, select, update on user_activity to hackertalk_writer_role;


create table user_auth
(
    identity_type      application.user_identity_type not null,
    identifier         varchar(32)                    not null,
    user_id            bigint                         not null
        constraint user_auth_user_fk
            references "user",
    credential         varchar(256)                   not null,
    refresh_credential varchar(256)                   not null,
    created_at         bigint                         not null,
    updated_at         bigint                         not null,
    constraint user_auth_pk
        primary key (identity_type, identifier)
);
alter table user_auth owner to postgres;
grant select on user_auth to hackertalk_reader_role;
grant delete, insert, select, update on user_auth to hackertalk_writer_role;


create table user_checkin
(
    id         bigint not null
        primary key,
    user_id    bigint not null
        constraint user_checkin_user_fk
            references "user",
    points     bigint not null,
    created_at bigint not null
);
alter table user_checkin owner to postgres;
grant select on user_checkin to hackertalk_reader_role;
grant delete, insert, select, update on user_checkin to hackertalk_writer_role;


create table user_following
(
    id           bigint not null
        primary key,
    user_id      bigint not null
        constraint user_following_user_fk
            references "user",
    following_id bigint not null
        constraint user_following_following_fk
            references "user",
    created_at   bigint not null
);
alter table user_following owner to postgres;
create unique index user_following_idx on user_following (user_id, following_id);
grant select on user_following to hackertalk_reader_role;
grant delete, insert, select, update on user_following to hackertalk_writer_role;


create table user_social_link
(
    id       bigint                            not null
        primary key,
    user_id  bigint                            not null,
    platform application.social_media_platform not null,
    username varchar(64)                       not null
);
alter table user_social_link owner to postgres;
grant select on user_social_link to hackertalk_reader_role;
grant delete, insert, select, update on user_social_link to hackertalk_writer_role;

