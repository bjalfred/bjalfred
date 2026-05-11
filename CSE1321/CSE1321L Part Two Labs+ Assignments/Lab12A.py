#Term: Spring 2025
#Instructor:Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab: Lab 12A


import pygame
from pygame.locals import *

pygame.init()

clock=pygame.time.Clock()
screen=pygame.display.set_mode((400,400))

line=pygame.Rect(180,0,50,400)
redSurf= pygame.Surface((line.w,line.h))
redSurf.fill((255,0,0))



sq=pygame.Rect(150,150,50,50)
blue=pygame.Surface((sq.w,sq.h))
blue.fill((0,0,255))
sq_speed=[5,0]

running= True

while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False

    if (sq.x<0 or sq.x>350):
        sq_speed[0]=-sq_speed[0]
        sq_speed[1]=-sq_speed[1]

    screen.fill((0, 0, 0))
    sq = sq.move(sq_speed)

    if(sq.colliderect(line)==True):
        redSurf.fill((0,255,0))
    if (sq.colliderect(line)==False):
        redSurf.fill((255,0,0))


    screen.blit(redSurf,(180,0))

    screen.blit(blue,(sq.x,sq.y))
    pygame.display.flip()
    clock.tick(60)