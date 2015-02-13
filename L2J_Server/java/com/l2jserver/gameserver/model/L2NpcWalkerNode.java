/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.model;

/**
 * @author Rayan RPG, JIV
 * @since 927
 */
public class L2NpcWalkerNode
{
	private final int _routeId;
	private String _chatText;
	private int _chatId = 0;
	private final int _moveX;
	private final int _moveY;
	private final int _moveZ;
	private final int _delay;
	private final boolean _running;
	
	public L2NpcWalkerNode(int routeId, String chatText, int moveX, int moveY, int moveZ, int delay, boolean running)
	{
		super();
		_routeId = routeId;
		_chatText = chatText;
		if (_chatText.startsWith("#"))
		{
			_chatId = Integer.parseInt(_chatText.substring(1));
		}
		else if (_chatText.trim().isEmpty())
		{
			_chatText = null;
		}
		_moveX = moveX;
		_moveY = moveY;
		_moveZ = moveZ;
		_delay = delay;
		_running = running;
	}
	
	public int getRouteId()
	{
		return _routeId;
	}
	
	public String getChatText()
	{
		if (_chatId != 0)
		{
			throw new IllegalStateException("Chat id is defined for walker route!");
		}
		return _chatText;
	}
	
	public int getMoveX()
	{
		return _moveX;
	}
	
	public int getMoveY()
	{
		return _moveY;
	}
	
	public int getMoveZ()
	{
		return _moveZ;
	}
	
	public int getDelay()
	{
		return _delay;
	}
	
	public boolean getRunning()
	{
		return _running;
	}
	
	public int getChatId()
	{
		return _chatId;
	}
}
