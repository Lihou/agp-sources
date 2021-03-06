/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.Log;
import com.android.ddmlib.Log.LogLevel;
import com.android.ddmlib.internal.MonitorThread;
import com.android.ddmlib.internal.ClientImpl;
import java.nio.ByteBuffer;

/** Handle thread status updates. */
public final class HandleTest extends ChunkHandler {

    public static final int CHUNK_TEST = type("TEST");

    private static final HandleTest mInst = new HandleTest();

    private HandleTest() {}

    /** Register for the packets we expect to get from the client. */
    public static void register(MonitorThread mt) {
        mt.registerChunkHandler(CHUNK_TEST, mInst);
    }

    /** Client is ready. */
    @Override
    public void clientReady(ClientImpl client) {}

    /** Client went away. */
    @Override
    public void clientDisconnected(ClientImpl client) {}

    /** Chunk handler entry point. */
    @Override
    public void handleChunk(
            ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {

        Log.d("ddm-test", "handling " + ChunkHandler.name(type));

        if (type == CHUNK_TEST) {
            handleTEST(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    /*
     * Handle a thread creation message.
     */
    private static void handleTEST(ClientImpl client, ByteBuffer data) {
        /*
         * Can't call data.array() on a read-only ByteBuffer, so we make
         * a copy.
         */
        byte[] copy = new byte[data.limit()];
        data.get(copy);

        Log.d("ddm-test", "Received:");
        Log.hexDump("ddm-test", LogLevel.DEBUG, copy, 0, copy.length);
    }
}

