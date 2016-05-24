package com.chenliujin.hadoop.mapreduce;

import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	static public AccessLog parse( String line ) throws Exception
	{
		String[] arr = line.split("\\|");

		AccessLog access_log = new AccessLog();

		access_log.setTimeLocal(arr[5]);
		access_log.setRemoteAddr(arr[0]);
		access_log.setRequest(arr[6]);
		access_log.setHttpReferer(arr[10]);
		access_log.setHttpUserAgent(arr[11]);
		access_log.setStatus(arr[7]);

		access_log.filterRemoteAddr();

		return access_log;
	}	

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setTimeLocal(String time_local) throws ParseException
	{
		Date date = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z").parse(time_local);
		
		this.time_local = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setRemoteAddr( String remote_addr )
	{
		this.remote_addr = remote_addr;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setRequest( String request )
	{
		this.request = request;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setHttpReferer( String http_referer )
	{
		this.http_referer = http_referer;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setHttpUserAgent( String http_user_agent )
	{
		this.http_user_agent = http_user_agent;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void setStatus( String status )
	{
		this.status = status;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public String getRemoteAddr()
	{
		return remote_addr;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	private void filterRemoteAddr() throws Exception
	{
		String[] ips = {
			"127.0.0.1",
			"182.254.154.128"
		};

		List<String> ip = Arrays.asList(ips);
		
		if (ip.contains(remote_addr)) {
			throw new Exception("filter remote_addr: " + remote_addr);
		}
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-16
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(this.time_local);
		sb.append("|").append(this.remote_addr);
		sb.append("|").append(this.request);

		return sb.toString();
	}

}
