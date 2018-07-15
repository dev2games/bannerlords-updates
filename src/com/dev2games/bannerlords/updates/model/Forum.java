package com.dev2games.bannerlords.updates.model;

/**
 * The TaleWorlds forum model. This class represents the data that we will be
 * fetching from the forum
 * 
 * @author Nelson Sanchez
 *
 */

public class Forum {

	// thread_id, title, author, content, avatar_url, date

	// The id of the thread
	public String threadId;

	// The tite of the thread
	public String title;

	// The author of the thread
	public String author;

	// The content of the thread
	public String content;

	// The url of the avatar
	public String avatarUrl;

	// The date the thread was posted
	public String date;

	/**
	 * Gets the thread id of the post
	 * 
	 * @return the thread id
	 */

	public String getThreadId() {
		return this.threadId;
	}

	/**
	 * Gets the title of the post
	 * 
	 * @return the title of the post
	 */

	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the author of the post
	 * 
	 * @return the author
	 */

	public String getAuthor() {
		return this.author;
	}

	/**
	 * Gets the content from the post
	 * 
	 * @return the content
	 */

	public String getContent() {
		return this.content;
	}

	/**
	 * Gets the url of the avatar
	 * 
	 * @return the avatar url
	 */

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	/**
	 * Gets the date the post was made
	 * 
	 * @return the thread date
	 */

	public String getDate() {
		return this.date;
	}

	/**
	 * Sets the thread id
	 * 
	 * @param threadId
	 *            the thread id
	 */

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	/**
	 * Sets the title of the thread
	 * 
	 * @param title
	 *            the title of the thread
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the author of the thread
	 * 
	 * @param author
	 *            the author of the thread
	 */

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Sets the thread content
	 * 
	 * @param content
	 *            the content in the thread
	 */

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Sets the date of the thread
	 * 
	 * @param date
	 *            the date of the thread
	 */

	public void getDate(String date) {
		this.date = date;
	}

}
