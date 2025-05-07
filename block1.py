#import hashlib
#import random
#import string
#import json
#import binascii
#import numpy as np
#import pandas as pd
#import pylab as pl
#import logging
import datetime
#import collections

#import Crypto
#import Crypto.Random
#from Crypto.Hash import SHA
#from Crypto.PublicKey import RSA
#from Crypto.Signature import PKCS1_v1_5

class ClientBlock:

    def __init__ (self, value):
        self.value = value
        self.time = datetime.datetime.now()
        self.previousBlockHash = "" 
        self.prev = None
        
    
    def getPreviousBlockHash(self):
        return self.previousBlockHash
    
    def setPrevBlockHash(self, hash):
        self.previousBlockHash = hash
    
    def setPrev(self, block):
        self.prev = block

    def getPrev(self):
        return self.prev
    
    def getData(self):
        return self.value
    
    def displayTransaction(self):
         print("value: " + str(self.value))
         print ('-----')
         print ("prev hash: " + str(self.previousBlockHash))
         print ('-----')
         print ("time: " + str(self.time))
         print ('-----')
    
    
class ServerBlock:
    
    def __init__(self, value, userID, uHash):
        self.value = value   
        self.time = datetime.datetime.now()
        self.previousBlockHash = ""
        self.userHash = uHash
        self.associatedUser = userID
        self.prev = None

    def getUserHash(self):
        return self.userHash

    def getAssociatedUser(self):
        return self.associatedUser
    
    def getPreviousBlockHash(self):
        return self.previousBlockHash
    
    def getUHash(self):
        return self.userHash
    
    def setPrevBlockHash(self, hash):
        self.previousBlockHash = hash

    def getPrev(self):
        return self.prev
    
    def setPrev(self, block):
        self.prev = block

    def displayTransaction(self):
         print("value: " + str(self.value))
         print ('-----')
         print ("prev hash: " + str(self.previousBlockHash))
         print ('-----')
         print ("time: " + str(self.time))
         print ('-----')
         print("userID: " + str(self.associatedUser))
         print ('-----')
         print("userHash: " + str(self.userHash))
         print ('-----')

    

