#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:11B

import pygame
from pygame.locals import *

pygame.init()

screen=pygame.display.set_mode((600,600))

surf1= pygame.Surface((60,60))
surf1.fill((255,0,0))
screen.blit(surf1,(0,0))
pygame.display.flip ()

surf2= pygame.Surface((60,60))
surf2.fill((255,0,0))
screen.blit(surf2,(0,540))
pygame.display.flip()

surf3=pygame.Surface((60,60))
surf3.fill((255,0,0))
screen.blit(surf3,(540,0))
pygame.display.flip()

surf4=pygame.Surface((60,60))
surf4.fill((255,0,0))
screen.blit(surf4,(540,540))
pygame.display.flip()

surf5=pygame.Surface((60,60))
surf5.fill((255,0,0))
screen.blit(surf5,(270,270))
pygame.display.flip()

running= True

while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False
        if event.type==KEYDOWN and event.key==K_ESCAPE:
            running= False