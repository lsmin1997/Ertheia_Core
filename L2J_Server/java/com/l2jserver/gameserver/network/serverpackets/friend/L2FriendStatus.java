/*
 * Copyright (C) 2004-2014 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.network.serverpackets.friend;

import com.l2jserver.gameserver.datatables.CharNameTable;
import com.l2jserver.gameserver.network.serverpackets.L2GameServerPacket;

/**
 * Support for "Chat with Friends" dialog. <br />
 * Inform player about friend online status change
 * @author JIV
 */
public class L2FriendStatus extends L2GameServerPacket
{
	private final boolean _online;
	private final int _classId;
	private final String _name;
	
	public L2FriendStatus(int objectId, boolean isOnline)
	{
		_classId = CharNameTable.getInstance().getClassIdById(objectId);
		_name = CharNameTable.getInstance().getNameById(objectId);
		_online = isOnline;
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0x59);
		writeD(_online ? 1 : 0);
		writeS(_name);
		writeD(_classId);
	}
}
