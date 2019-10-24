DROP PROCEDURE IF EXISTS import_root_hsbc_dept;
DROP PROCEDURE IF EXISTS import_hsbc_dept;

CREATE  PROCEDURE `import_hsbc_dept`(IN dept_id int,IN d_p_id varchar(32))
BEGIN
-- 	declare dept_id int;
  declare dept_name varchar(64);
--    遍历数据结束标志
  declare done int default false;
--    声明游标
  declare cursor_dept cursor for SELECT `ID`,`NAME`
	FROM t_hsbc_dept 
	where PARENT_ID = dept_id;
	
--   将结束标志
  declare continue handler for not found set done = true;	
	SET @@max_sp_recursion_depth = 100;	
--   打开游标 
  open cursor_dept;
--     提取游标里的数据；
   fetch cursor_dept into dept_id,dept_name;
--   开始循环
	 WHILE !done DO 
--     这里做你想做的循环的事件
    set @var_dic_id:=REPLACE(UUID(),'-','');
	  INSERT INTO `b_data_dictionary` 
		VALUES (@var_dic_id,@var_type_code, @var_type_name,dept_id,dept_name,dept_id,dept_name,0,d_p_id); 
		call `import_hsbc_dept`(dept_id,@var_dic_id);
		fetch cursor_dept into dept_id,dept_name;
	 END WHILE;
--   关闭游标
  close cursor_dept;
END;
-- ----------------------------------------------------------------------------
CREATE PROCEDURE `import_root_hsbc_dept`()
BEGIN
	 declare dept_id int;
  declare dept_name varchar(64);
--    遍历数据结束标志
  declare done int default false;
--    声明游标
  declare cursor_dept cursor for SELECT `ID`,`NAME`
	FROM t_hsbc_dept 
	where PARENT_ID IS null;
	
--   将结束标志
  declare continue handler for not found set done = true;	
	SET @@max_sp_recursion_depth = 100;
   set @var_type_code = 16,@var_type_name = 'hsbcDept',@var_param_code = 1,@var_dic_id=REPLACE(UUID(),'-','');		
-- 		DELETE hsbcDept dictionary
	delete from b_data_dictionary where TYPE_NAME=@var_type_name; 	
	INSERT INTO `b_data_dictionary` VALUES (@var_dic_id,@var_type_code, @var_type_name,0,'全部',0,'All',0,null); 
	
--   打开游标 
  open cursor_dept;
--     提取游标里的数据；
   fetch cursor_dept into dept_id,dept_name;
--   开始循环
	 WHILE !done DO 
--     这里做你想做的循环的事件
    set @var_dic_id:=REPLACE(UUID(),'-','');
	  INSERT INTO `b_data_dictionary` 
		VALUES (@var_dic_id,@var_type_code, @var_type_name,dept_id,dept_name,dept_id,dept_name,0,null); 
		call `import_hsbc_dept`(dept_id,@var_dic_id);
		fetch cursor_dept into dept_id,dept_name;
	 END WHILE;
--   关闭游标
  close cursor_dept;
END;

call import_root_hsbc_dept();

DROP PROCEDURE IF EXISTS import_root_hsbc_dept;
DROP PROCEDURE IF EXISTS import_hsbc_dept;

 
