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
from blockchain2 import *
from block1 import *

class Server:
    def __init__(self):
        self.hashList = ServerBlockChain()
        self.database = []
        #self._private_key = RSA.generate(1024, random)
        #self._public_key = self._private_key.publickey()
        #self.hashList.startChain()

    def getInfo(self, info:int, expectedLastHash:int, clientID):
        #compare expected last hash with the hash on file for that client
        print("expected: " + str(expectedLastHash))
        print("server: " + str(self.getLastHash(clientID)))
        if(expectedLastHash == self.getLastHash(clientID)):
            #return the info
            print("yay")
            return "info"
        else:
            #return nothing
            print("boo")
            return "nothing"


    def getLastHash(self, clientID):
        #check list to find the hash corresponding with the client
        return self.hashList.searchClientHash(clientID)
    
    @property
    def identity(self):
      return "server"

class Client:

   def __init__(self, server:Server):
      #generate an id
      random = Crypto.Random.new().read
      self._private_key = RSA.generate(1024, random)
      self._public_key = self._private_key.publickey()
      #generate signature
      self._signer = PKCS1_v1_5.new(self._private_key)
      #set server variable
      self.myServer =server

      #create personal blockchain
      #print("start chain")
      self.hashList = ClientBlockchain()
      
      #add self to server
      #add node to personal chain denoting server connection
      #add node to server chain denoting added user
      newBlock = ClientBlock("connect to Server")
      self.addToChain(newBlock)
      #print(str(self.hashList.getLastHash()))
      #self.myServer.hashList.addToChain("add User", self.identity, self.hashList.getLastHash())

      
   def requestInfo(self):
      info = self.myServer.getInfo(1, self.getLastHash(), self.identity)
      #create a block
      t0 = ClientBlock(info)

      #add it to own chain
      self.hashList.addToChain(t0)

      #send info to server to add to own chain
      #print(str(self.hashList.getLastHash()))
      self.myServer.hashList.addToChain(info,self.identity,self.hashList.getLastHash())
      

   def getLastHash(self):
      return self.hashList.lastBlockHash
   
   def addToChain(self, block:ClientBlock):
      self.hashList.addToChain(block)
      self.myServer.hashList.addToChain(block.getData(), self.identity, self.getLastHash())

   @property
   def identity(self):
      return binascii.hexlify(self._public_key.exportKey(format='DER')).decode('ascii')