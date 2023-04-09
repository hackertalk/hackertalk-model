-- channel views -----------------------------------------------------------------------------------
create view channel_member_count as
select application.channel.id                       AS channel_id,
       count(application.channel_member.channel_id) AS member_count
from (application.channel left join application.channel_member
      on ((application.channel.id = application.channel_member.channel_id)))
group by application.channel.id
order by application.channel.id;


create view channel_online_count as
select c.id AS channel_id, count(cs.channel_id) AS online_count
from (application.channel c left join application.channel_subscription cs
      on ((c.id = cs.channel_id)))
group by c.id
order by c.id;


-- todo: check values
create view channel_metrics as
select cmc.channel_id   AS channel_id,
       cmc.member_count AS member_count,
       coc.online_count AS online_count
from application.channel_member_count cmc
         join application.channel_online_count coc on (cmc.channel_id = coc.channel_id);

-- comment views -----------------------------------------------------------------------------------
create view comment_like_count as
select application.comment.id                     AS comment_id,
       count(application.comment_like.comment_id) AS like_count
from (application.comment left join application.comment_like
      on ((application.comment.id = application.comment_like.comment_id)))
group by application.comment.id
order by application.comment.id;


create view comment_reply_count as
with recursive cte as (select t0.id        AS id,
                              t0.parent_id AS parent_id,
                              t0.parent_id AS comment_id
                       from (application.comment t0 left join application.comment ids
                             on ((t0.parent_id = ids.id)))
                       union all
                       select child.id          AS id,
                              child.parent_id   AS parent_id,
                              parent.comment_id AS comment_id
                       from (application.comment child join cte parent
                             on ((child.parent_id = parent.id))))
select c0.id AS comment_id, coalesce(c1.reply_count, 0) AS reply_count
from (application.comment c0 left join (select cte.comment_id        AS comment_id,
                                               count(cte.comment_id) AS reply_count
                                        from cte
                                        group by cte.comment_id) c1
      on ((c0.id = c1.comment_id)));


create view comment_metrics as
select l.comment_id  AS comment_id,
       l.like_count  AS like_count,
       r.reply_count AS reply_count
from (application.comment_like_count l left join application.comment_reply_count r
      on ((l.comment_id = r.comment_id)));

-- post views --------------------------------------------------------------------------------------
create view post_comment_count as
select application.post.id                        AS post_id,
       coalesce(count(application.comment.id), 0) AS comment_count
from (application.post left join application.comment
      on (((application.post.id = application.comment.post_id) and
           (application.comment.blocked = false) and
           (application.comment.deleted = false))))
group by application.post.id
order by application.post.id;


create view post_favorite_count as
select application.post.id                                   AS post_id,
       coalesce(count(application.post_favorite.post_id), 0) AS favorite_count
from (application.post left join application.post_favorite
      on ((application.post.id = application.post_favorite.post_id)))
group by application.post.id
order by application.post.id;


create view post_impression_count as
select application.post.id                                AS post_id,
       coalesce(count(application.post_impression.id), 0) AS impression_count
from (application.post left join application.post_impression
      on ((application.post.id = application.post_impression.post_id)))
group by application.post.id
order by application.post.id;


create view post_like_count as
select application.post.id                               AS post_id,
       coalesce(count(application.post_like.post_id), 0) AS like_count
from (application.post left join application.post_like
      on ((application.post.id = application.post_like.post_id)))
group by application.post.id
order by application.post.id;


create view post_metrics as
select application.post_comment_count.post_id             AS post_id,
       application.post_comment_count.comment_count       AS comment_count,
       application.post_like_count.like_count             AS like_count,
       application.post_favorite_count.favorite_count     AS favorite_count,
       application.post_impression_count.impression_count AS impression_count
from application.post_comment_count
         join application.post_like_count
              on application.post_comment_count.post_id = application.post_like_count.post_id
         join application.post_favorite_count
              on application.post_comment_count.post_id = application.post_favorite_count.post_id
         join application.post_impression_count
              on application.post_comment_count.post_id = application.post_impression_count.post_id;


-- user views --------------------------------------------------------------------------------------
create view user_checkin_points as
select application.user.id                               AS user_id,
       coalesce(sum(application.user_checkin.points), 0) AS points
from (application.user left join application.user_checkin
      on ((application.user.id = application.user_checkin.user_id)))
group by application.user.id
order by application.user.id;


create view user_followers_count as
select application.user.id                            AS user_id,
       count(application.user_following.following_id) AS followers_count
from (application.user left join application.user_following
      on ((application.user.id = application.user_following.following_id)))
group by application.user.id
order by application.user.id;


create view user_following_count as
select application.user.id                       AS user_id,
       count(application.user_following.user_id) AS following_count
from (application.user left join application.user_following
      on ((application.user.id = application.user_following.user_id)))
group by application.user.id
order by application.user.id;


create view user_post_count as
select application.user.id AS user_id, count(application.post.id) AS post_count
from (application.user left join application.post
      on (((application.user.id = application.post.from_id) and
           (application.post.deleted = false) and (application.post.blocked = false))))
group by application.user.id
order by application.user.id;


-- todo: check values
create view user_metrics as
select application.user.id                              AS user_id,
       application.user_post_count.post_count           AS post_count,
       application.user_following_count.following_count AS following_count,
       application.user_followers_count.followers_count AS followers_count
from application.user
         join application.user_post_count
              on application.user.id = application.user_post_count.user_id
         join application.user_following_count
              on application.user.id = application.user_following_count.user_id
         join application.user_followers_count
              on application.user.id = application.user_followers_count.user_id;

