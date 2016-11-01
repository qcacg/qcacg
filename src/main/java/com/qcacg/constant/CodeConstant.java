package com.qcacg.constant;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by CaiYuanYu on 2016/10/26.
 */
public class CodeConstant {

    public final static int ERROR_CODE = 500;

    public final static String SUCCESS_SEND = "验证码发送成功，请稍候片刻";

    public final static String SUCCESS_DELETE = "删除成功";

    public final static String SUCCESS_SAVE = "保存成功";

    public final static String SUCCESS_COMMIT = "提交成功";

    public final static String SUCCESS_SET = "设置成功";
    /*
    异常类code
     */
    //Exception
    public final static String SYS_CODE = "999";
    public final static String SYS_CODE_MSG = "服务器异常";

    //SQLException
    public final static String SQL_CODE_MSG = "数据库异常";

    //IOException
    public final static String IO_CODE_MSG = "读写操作异常";

    //RuntimeException
    public final static String RUNTIME_CODE = "996";
    public final static String RUNTIME_CODE_MSG = "用户操作不当";

    /*
    参数异常code
     */

    public final static String PARAMETER_CODE = "9001";

    //public final static String NOT_NULL_CODE = "979";
    public final static String BOOKNAME_IS_NULL = "书名不能为空";
    public final static String TELEPHONE_IS_NULL = "手机号不能为空";
    public final static String PWD_IS_NULL = "密码不能为空";
    public final static String VALUE_NO_INPUT = "请输入验证码";
    public final static String TITLE_IS_NULL = "标题不能为空";
    public final static String TEXT_IS_NULL = "请输入小说内容";
    public final static String VOLUMENAME_IS_NULL = "请输入卷名";
    public final static String FILE_TOO_SMALL = "文件太小!";
    public final static String CHAPTER_NAME_ERROR = "章节名不合法";

    //public final static String IS_EXIST_CODE = "978";
    public final static String BOOKNAME_IS_EXIST = "该书名已存在";
    public final static String TELEPHONE_IS_EXIST = "该手机号已被注册";

    //public final static String IDENTIFYING_CODE = "977";
    public final static String IDENTIFYING_ERROR = "验证码不正确";

    //public final static String NOT_EXIST_CODE = "976";
    public final static String TELEPHONE_NOT_EXIST ="该手机号不存在，如有需要联系网站管理员";
    public final static String TELEPHONE_NOT_REGIST = "该手机号码还未注册";

    //public final static String NULL_SELECT_CODE ="975";
    public final static String NULL_SELECT_MSG = "请选择要删除的书籍";
    public final static String THE_LAST_CONTENT = "已经是最后一章了。";
    public final static String THE_FIRST_CONTENT = "已经到最前一章了。";

    //public final static String UNABLE_HANDLE_CODE = "974";
    public final static String UNABLE_HANDLE_PARAM = "参数不合法";
    public final static String VOLUMENAME_TOO_LONG = "卷名过长，请不要超过15个字";
    public final static String CHAPTERNAME_TOO_LONG = "章节名过长，请不要超过15个字！";

    //public final static String REGISTER_CODE = "973";
    public final static String REGISTER_MSG = "密码不一致，请确认密码。";

    /*
    未登录,请求被拦截
     */
    public final static String TO_LOGIN_CODE = "900";
    public final static String RELOGIN_MSG = "您还未登录，请登录后在执行此操作！！！";

    /*
    时间超时
     */
    public final static String OUT_OF_TIME_CODE = "1000";
    public final static String OUT_OF_TIME_MSG = "登录超时，请重新登录";
    public final static String CODE_TIME_OUT_MSG = "验证码已过期，请重新获取验证码！！！";
}
