
import pygame
import random
from Config import *

pygame.init()
pygame.mixer.init()

class Meteor:
    def __init__(self):
        self.Type=random.choice(["big","med","small","tiny"])
        self.speed=SPEED_PATH[self.Type]
        self.sprite=random.choice(IMAGE_PATH[self.Type])
        self.sprite = pygame.image.load(self.sprite).convert_alpha()
        self.rect=self.sprite.get_rect()

        self.spawn_sound=random.choice(list(SOUND_PATH.keys()))
        self.spawn_sound=pygame.mixer.Sound(SOUND_PATH[self.spawn_sound][0])

        randX=random.randint(0,WIDTH-self.rect.width)
        self.rect.topleft=(randX,0)
    def fall(self):
        self.rect=self.rect.move(0,self.speed)
    def draw(self):
        screen.blit(self.sprite,self.rect)
    def play_spawn_sound(self):
        self.spawn_sound.play()
