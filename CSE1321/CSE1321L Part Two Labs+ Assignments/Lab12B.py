#Term: Spring 2025
#Instructor:Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab: Lab 12B



import pygame
from pygame.locals import *

pygame.init()

clock=pygame.time.Clock()
screen=pygame.display.set_mode((400,400))

line=pygame.Rect(180,0,50,400)
redSurf= pygame.Surface((line.w,line.h))
redSurf.fill((255,0,0))


midSq=pygame.Rect(175,175,50,50)
middle=pygame.Surface((midSq.w,midSq.h))
middle.fill((0,0,255))
midSq_speed=[5,0]

topSq=pygame.Rect(0,0,50,50)
top=pygame.Surface((topSq.w,topSq.h))
top.fill((0,0,255))
topSq_speed=[10,0]

lowSq=pygame.Rect(0,350,50,50)
low=pygame.Surface((lowSq.w,lowSq.h))
low.fill((0,0,255))
lowSq_speed=[20,0]


running= True

while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False

    if (midSq.x<0 or midSq.x>350):
        midSq_speed[0]=-midSq_speed[0]
        midSq_speed[1]=-midSq_speed[1]
    if(topSq.x<0 or topSq.x>350):
        topSq_speed[0]=-topSq_speed[0]
        topSq_speed[1]=-topSq_speed[1]
    if (lowSq.x<0 or lowSq.x>350):
        lowSq_speed[0] =-lowSq_speed[0]
        lowSq_speed[1]=-lowSq_speed[1]



    screen.fill((0, 0, 0))
    midSq = midSq.move(midSq_speed)
    topSq= topSq.move(topSq_speed)
    lowSq= lowSq.move(lowSq_speed)

    list1=[midSq,topSq,lowSq]

    if line.collidelistall(list1):
        redSurf.fill((0,255,0))
    else:
        redSurf.fill((255, 0, 0))


    screen.blit(redSurf,(180,0))

    screen.blit(top,(topSq.x,topSq.y))

    screen.blit(low,(lowSq.x,lowSq.y))

    screen.blit(middle,(midSq.x,midSq.y))

    pygame.display.flip()
    clock.tick(60)