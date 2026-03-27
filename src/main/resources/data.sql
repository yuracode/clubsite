INSERT INTO users (nickname, email, password, profile_image) VALUES
('sasaki', 'asahi@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_1.svg'),
('蒼井颯', 'aoi@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_2.svg'),
('東雲悠', 'shinonome@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_3.svg'),
('柊翔', 'hiiragi@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_4.svg'),
('霧島蓮', 'kirishima@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_5.svg'),
('Aryan Dev', 'aryan@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_6.svg'),
('アリヤン・デヴ', 'aryandev@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_7.svg'),
('アリヤンの娘', 'aryansdaughter@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_8.svg'),
('霧島蓮の息子', 'kirishimakid@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_9.svg'),
('蒼井颯の彼女', 'aoigf@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '/avatars/avatar_10.svg');

INSERT INTO posts (title, content, category, author_id) VALUES
('練習のお知らせ', '今週土曜日は通常練習です。グラウンドに9時集合してください。', 'PRACTICE', 1),
('大会結果報告', '先週の大会では3位入賞することができました！', 'TOURNAMENT', 2),
('休みのお知らせ', '来週月曜日は祝日のため練習はお休みです。', 'HOLIDAY', 3),
('雑談コーナー', 'みなさん最近調子はどうですか？', 'OTHER', 4),
('練習メニュー変更', '今週の練習メニューが変更になりました。詳細は以下をご確認ください。', 'PRACTICE', 5),
('全国大会出場決定', '地区予選を勝ち抜き、全国大会出場が決定しました！', 'TOURNAMENT', 1),
('合宿について', '夏合宿の日程が決まりました。参加希望者は連絡してください。', 'OTHER', 2),
('練習試合のお知らせ', '来月、隣町のチームと練習試合を行います。', 'PRACTICE', 3),
('表彰式のお知らせ', '今週末に表彰式があります。参加できる方は連絡してください。', 'TOURNAMENT', 4),
('お盆休みについて', 'お盆期間中は練習をお休みします。', 'HOLIDAY', 5);

INSERT INTO schedules (date, title, detail, user_id) VALUES
('2026-03-25', '練習', 'グラウンドにて通常練習', 1),
('2026-03-28', '練習試合', '隣町チームとの練習試合', 2),
('2026-04-01', '全国大会', '全国大会一日目', 3),
('2026-04-05', '合宿', '春合宿スタート', 1),
('2026-03-30', '表彰式', '地区大会表彰式', 4);

INSERT INTO tournaments (name, held_year, held_month, first_place, second_place, third_place, my_rank, my_team_name) VALUES
('第30回東京大会', 2025, 12, '鹿児島県', '宮崎県', '埼玉県', 95, '自分たち'),
('第29回東京大会', 2024, 12, '小樽市', '千葉市', '東京都', 5, '自分たち'),
('第28回東京大会', 2024, 6, '大阪市', '名古屋市', '横浜市', 10, '自分たち');

INSERT INTO favorites (user_id, target_id) VALUES
(1, 2),
(1, 3),
(2, 1);
