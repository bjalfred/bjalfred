import pygame
from pygame.locals import *
import random
import Config
from Meteor import *
from Player import *

pygame.init()
pygame.mixer.init()
screen=pygame.display.set_mode((WIDTH,HEIGHT))
clock=pygame.time.Clock()
pygame.time.set_timer(METEOR_SPAWN, 1000)
text=pygame.font.Font(None, 48)
loseTXT= text.render("You Lost",True,WHITE)


loseScreen=pygame.Surface((WIDTH,HEIGHT))
loseScreen.fill(BLACK)
loseScreen.set_alpha(100)

background=pygame.image.load("bg.png")


Meteors=[]
player=Player()
running=True

while running:
    meteor = Meteor()
    keys = pygame.key.get_pressed()
    for event in pygame.event.get():
        if event.type==pygame.QUIT:
            running=False
        if event.type == METEOR_SPAWN:
            Meteors.append(meteor)
            meteor.play_spawn_sound()

            meteorshower=random.randint(800,1500)
            pygame.time.set_timer(METEOR_SPAWN, meteorshower)


    screen.blit(background, (0, 0))

    if player.alive:
        player.move(keys)
        player.draw(screen)


    for meteor in Meteors:
        meteor.draw()
        meteor.fall()
        if meteor.rect.y > 800:
            Meteors.remove(meteor)
        if player.rect.colliderect(meteor.rect):
            player.alive=False
            ALIENDEATH.play()
            Meteors.remove(meteor)
        if not player.alive:
            screen.blit(loseScreen,(0,0))
            screen.blit(loseTXT, (160, 420))

    pygame.display.flip()
    clock.tick(Config.FPS)


