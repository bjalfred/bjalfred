#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:11C

import pygame
from pygame.display import get_surface
from pygame.locals import *

screen= pygame.display.set_mode((1000,500))
clock= pygame.time.Clock()

grect= pygame.Rect(0,0,100,100)
gsurf= pygame.Surface((grect.w,grect.h))
gsurf.fill((0,255,0))
grect_speed=[5,0]

brect= pygame.Rect(0,400,100,100)
bsurf= pygame.Surface((brect.w,brect.h))
bsurf.fill((0,0,255))
brect_speed=[5,0]



running= True

while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False


    if (grect.x<0 or grect.x>900) and (brect.x<0 or brect.x>900):
        grect_speed[0]=-grect_speed[0]
        grect_speed[1]=-grect_speed[1]
        brect_speed[0]=-brect_speed[0]
        brect_speed[1]=-brect_speed[1]

    screen.fill((0,0,0))
    grect=grect.move(grect_speed)
    screen.blit(gsurf,(grect.x,grect.y))


    brect =brect.move(brect_speed)
    screen.blit(bsurf, (brect.x, brect.y))

    pygame.display.flip()
    clock.tick(60)