import hashlib

from block1 import *
from blockchain1 import *
from client1 import *

server = Server()

user1 = Client(server)
#user1LastHash = user1.getLastHash
#user2 = Client(server)
#user2LastHash = user2.getLastHash

user1.requestInfo()

#user2.requestInfo()
#user2.requestInfo()

user1.hashList.dumpChain()
#user2.hashList.dumpChain()

server.hashList.dumpChain()
