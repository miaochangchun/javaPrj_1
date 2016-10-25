package com.miao.util;

public class PageUtil {
	/**
	 * 构造函数，分页辅助类，必须要知道三个参数，当前页，每页显示的记录数以及总记录数，其他参数可以通过这三个参数计算出来。
	 * @param everyPage		每页显示的记录数
	 * @param totalCount	总的记录数
	 * @param currentPage	当前页
	 * @return
	 */
	public static Page createPage(int everyPage, int totalCount, int currentPage){
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,beginIndex, hasPrePage, hasNextPage);
	}

	/**
	 * 是否有下一页，当前页等于总页数没有下一页，总页数为0，也没有下一页
	 * @param totalPage		总页数
	 * @param currentPage	当前页
	 * @return
	 */
	private static boolean getHasNextPage(int totalPage, int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == totalPage | totalPage == 0 ? false : true;
	}

	/**
	 * 是否有上一页
	 * @param currentPage
	 * @return
	 */
	private static boolean getHasPrePage(int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == 1 ? false : true;
	}
	
	/**
	 * 获取当前页的起始index数
	 * @param everyPage		每页显示的记录数
	 * @param currentPage	当前页
	 * @return
	 */
	private static int getBeginIndex(int everyPage, int currentPage) {
		// TODO Auto-generated method stub
		return (currentPage - 1) * everyPage;
	}

	/**
	 * 获取总的页数，总的记录数/每页显示的记录数+1
	 * @param everyPage		每页心事记录数
	 * @param totalCount	总的记录数
	 * @return
	 */
	private static int getTotalPage(int everyPage, int totalCount) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		}else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	
	/**
	 * 获得当前页的页数，默认位第一页，否则为设置的页数
	 * @param currentPage	当前页的设置参数
	 * @return
	 */
	private static int getCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * 获得每页显示的记录数，默认是10条记录，如果设置了就使用设置的记录数
	 * @param everyPage
	 * @return
	 */
	private static int getEveryPage(int everyPage) {
		// TODO Auto-generated method stub
		return everyPage == 0 ? 10 : everyPage;
	}
}
