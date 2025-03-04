USE board_springboot;

INSERT INTO users (user_id, user_name, password,phone_no,created_at) VALUES
                                          ('test1', '홍길동','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe','01012345678','2025-03-01 03:37:51'),
                                          ('test2', '김철수','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe','01012123434','2025-03-01 03:37:51'),
                                          ('test3', '김영희','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe','01099997777','2025-03-01 03:37:51');


INSERT INTO boards (title, content, user_no) VALUES
                                                   ('테스트 게시글입니다', '테스트 중입니다.', 1),
                                                   ('테스트 게시글입니다22', '테스트 중입니다.2222', 2),
                                                   ('테스트 게시글입니다333333333333333333333333333333333333333333333', '테스트 중입니다.3333', 3);

INSERT INTO password_change_logs (user_id,changed_password) VALUES
                                                                ('test1','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe'),
                                                                ('test2','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe'),
                                                                ('test3','$2a$10$2cAGFCZKaya/tR2CokiYzuJZMukEg.xZsqW6jxgKjat6v3fwfMGQe');


