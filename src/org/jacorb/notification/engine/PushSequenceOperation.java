package org.jacorb.notification.engine;

/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1997-2004 Gerald Brose.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

import org.jacorb.notification.interfaces.MessageConsumer;
import org.omg.CosEventComm.Disconnected;
import org.omg.CosNotification.StructuredEvent;
import org.omg.CosNotifyComm.SequencePushConsumer;

/**
 * @author Alphonse Bendt
 * @version $Id$
 */
public class PushSequenceOperation implements PushOperation
{
    private final SequencePushConsumer sequencePushConsumer_;

    private final StructuredEvent[] structuredEvents_;

    private final MessageConsumer messageConsumer_;

    public PushSequenceOperation(MessageConsumer messageConsumer,
            SequencePushConsumer pushConsumer, StructuredEvent[] structuredEvents)
    {
        messageConsumer_ = messageConsumer;
        sequencePushConsumer_ = pushConsumer;
        structuredEvents_ = structuredEvents;
    }

    public void invokePush() throws Disconnected
    {
        sequencePushConsumer_.push_structured_events(structuredEvents_);

        messageConsumer_.resetErrorCounter();
    }

    public void dispose()
    {
        // nothing to do
    }
}
