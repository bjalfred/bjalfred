#Term: Spring 2025
#Instructor:Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab: Lab 12C

import pygame
from pygame.locals import *

pygame.init()
Clock= pygame.time.Clock()
screen=pygame.display.set_mode((500,500))

play= pygame.Rect(225,225,50,50)
player=pygame.Surface((50,50))
player.fill((0,0,255))
play_speed=[5,0]

running=True





while running:
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False

    keys=pygame.key.get_pressed()

    if keys[pygame.K_w]:
        if play.y>=5:
            play=play.move(0,-5)
            print("[EVENT] KEY STATE: W KEY IS BEING PRESSED -> MOVING PLAYER UP")
        else:
            print("[EVENT] KEY STATE: W KEY IS BEING PRESSED -> CANNOT MOVE PLAYER OUT OF BOUNDS")
    if keys[pygame.K_s]:
        if(play.y<=450):
            play= play.move(0,5)
            print("[EVENT] KEY STATE: S KEY IS BEING PRESSED -> MOVING PLAYER DOWN")
        else:
            print("[EVENT] KEY STATE: S KEY IS BEING PRESSED -> CANNOT MOVE PLAYER OUT OF BOUNDS")
    if keys[pygame.K_d]:
        if play.x<450:
            play=play.move(5,0)
            print("[EVENT] KEY STATE: D KEY IS BEING PRESSED -> MOVING PLAYER RIGHT")
        else:
            print("[EVENT] KEY STATE: D KEY IS BEING PRESSED -> CANNOT MOVE PLAYER OUT OF BOUNDS")

    if keys[pygame.K_a]:
        if play.x>0:
            play=play.move(-5,0)
            print("[EVENT] KEY STATE: A KEY IS BEING PRESSED -> MOVING PLAYER LEFT")
        else:
            print("[EVENT] KEY STATE: A KEY IS BEING PRESSED -> CANNOT MOVE PLAYER OUT OF BOUNDS")
    if keys[pygame.K_r]:
        play.x=225
        play.y=225
        print("[EVENT] KEYDOWN: USER PRESSED BUTTON R -> RESETTING PLAYER POSITION")


    screen.fill((0,0,0))
    screen.blit(player,(play.x, play.y))
    pygame.display.flip()
    Clock.tick(60)