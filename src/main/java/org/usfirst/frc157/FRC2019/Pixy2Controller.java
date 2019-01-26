/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.I2C;

/**
 * Add your docs here.
 */
public class Pixy2Controller{
    public final byte[] GETBLOCKS = {(byte)174, (byte)193, (byte)32, (byte)2, (byte)0, (byte)0};
    private byte[] packetHead = new byte[6];
    private I2C pixy;
    public Pixy2Controller(I2C.Port port, int address)
    {
        this.pixy = new I2C(port, address);
    }
    public boolean badInput(int[] signatures, int maxBlocks)
    {
        boolean retval = false;
        if (maxBlocks > 255 || maxBlocks < 0 || signatures.length > 8 || signatures.length <= 0)
        {
            retval = true;
        }
        for (int i:signatures)
        {
            if (i < 1 || i > 8)
            {
                retval = false;
            }
        }
        return retval;
    }
    public Byte mask(int[] signatures)
    {
        byte retval = 0;
        for (int i:signatures)
        {
            retval |= 1<<i-1;
        }
        return retval;
    }
    public boolean read(int signature)
    {
        return read(new int[]{signature}, 255);
    }
    public boolean read(int[] signature)
    {
        return read(signature, 255);
    }
    public boolean read(int signature, int maxBlocks)
    {
        return read(new int[]{signature}, maxBlocks);
    }
    public boolean read(int[] signatures, int maxBlocks)
    {
        if (badInput(signatures, maxBlocks))
        {
            return false;
        }
        Byte sigmap = mask(signatures);
        byte[] writeBytes = GETBLOCKS;
        writeBytes[4] = sigmap;
        writeBytes[5] = (byte)maxBlocks;
        pixy.writeBulk(writeBytes);
        packetHead = new byte[6];
        pixy.readOnly(packetHead, 6);
        byte[] packetBody = new byte[packetHead[3]];
        pixy.readOnly(packetBody, packetHead[3]);
        return true;

    }
}
