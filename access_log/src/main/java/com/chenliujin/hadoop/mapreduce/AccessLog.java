package com.chenliujin.mapreduce;

public class AccessLog
{
	private String time_local;
	private String remote_addr;
	private String request;
	private String http_referer;
	private String http_user_agent;
	private String status;

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	static public function parse(String.line)
	{
		System.out.println(line);
	}	
}
