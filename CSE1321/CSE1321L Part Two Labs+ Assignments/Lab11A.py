#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:11A

import pygame
from pygame.locals import *

screen=pygame.display.set_mode((400,400))
clock=pygame.time.Clock()

black=0

direction=1

running= True

while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False
        if event.type==KEYDOWN and event.key==K_ESCAPE:
            running= False

    screen.fill ((black,black,black))
    pygame.display.flip()

    black+=direction

    if black>255:
        direction=-1
        black=255
    if black<0:
        direction=1
        black=0
    clock.tick(30)