use edusys;
alter table course add constraint credCheck check(credits>=3);