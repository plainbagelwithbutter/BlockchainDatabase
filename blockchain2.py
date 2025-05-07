# import libraries
import hashlib
import random
import string
import json
import binascii
import numpy as np
import pandas as pd
import pylab as pl
import logging
import datetime
import collections

import Crypto
import Crypto.Random
from Crypto.Hash import SHA
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5
from block1 import *

class ClientBlockchain:
    def __init__(self):
        self.lastBlockHash = ""
        self.numBlocks = 0
        self.lastBlock:ClientBlock = None
        firstBlock = ClientBlock("start")
        #print("STARTING CLIENT CHAIN")
        self.startChain(firstBlock)
        self.lastBlockHash = hash(firstBlock)
        
    def startChain(self, block:ClientBlock):
        block.prev = None
        block.setPrevBlockHash(None)
        self.lastBlock = block
        self.numBlocks += 1


    def addToChain(self, block:ClientBlock):
        block.setPrev(self.getLastBlock())
        #print(str(self.getLastHash())) 
        block.setPrevBlockHash(hash(self.getLastBlock()))
        self.setHash(self.getLastBlock())
        self.setLastBlock(block)
        self.numBlocks += 1

    def setLastBlock(self, block:ClientBlock):
        self.lastBlock = block

    def getLastBlock(self):
        return self.lastBlock
    
    def dumpChain(self):
        print("Number of blocks: " + str(self.numBlocks))
        tempBlock:ClientBlock = self.getLastBlock()
        for x in range(self.numBlocks):
                print("block #" + str(self.numBlocks - x))
                tempBlock.displayTransaction()
                print("===============================")
                tempBlock = tempBlock.getPrev()
    
    def getLastHash(self):
        #print("getting hash")
        return self.lastBlockHash
    
    def setHash(self, block:ClientBlock):
        self.lastBlockHash = hash(block)
    
class ServerBlockChain:
    def __init__(self):
        self.lastBlockHash = ""
        self.numBlocks = 0
        self.lastBlock:ServerBlock = None
        firstBlock = ServerBlock("start", None, None)
        self.startChain(firstBlock)

    def startChain(self, block:ServerBlock):
        block.prev = None
        block.setPrevBlockHash(None)
        self.lastBlock = block
        self.numBlocks += 1

    def addToChain(self, data, userID, userHash):
        block = ServerBlock(data, userID, userHash)
        block.setPrev(self.getLastBlock()) 
        block.setPrevBlockHash(hash(self.getLastBlock()))
        self.setLastBlock(block)
        self.numBlocks += 1

    def setLastBlock(self, block:ServerBlock):
        self.lastBlock = block

    def getLastBlock(self):
        return self.lastBlock
    
    def dumpChain(self):
        print("Number of blocks: " + str(self.numBlocks))
        tempBlock:ServerBlock = self.getLastBlock()
        for x in range(self.numBlocks):
                print("block #" + str(self.numBlocks-x))
                tempBlock.displayTransaction()
                print("===============================")
                tempBlock = tempBlock.getPrev()
    
    def getLastHash(self):
        return self.lastBlockHash
    
    def searchClientHash(self, clientID):
        tempBlock:ServerBlock = self.getLastBlock()
        for x in range(self.numBlocks):
              
              if (tempBlock.getAssociatedUser() == clientID):
                  #print("success")
                  return tempBlock.getUserHash()
              else:
                  #print(clientID)
                  #print("fail")
                  tempBlock = tempBlock.getPrev()