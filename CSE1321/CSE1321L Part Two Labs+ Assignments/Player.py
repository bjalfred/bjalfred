from Config import *
import pygame

pygame.init()
pygame.mixer.init()


class Player:
    def __init__(self):
        self.speed=PLAYER_SPEED
        self.sprite=ALIEN
        self.rect=self.sprite.get_rect(center=(240, 710))
        self.alive=True
        self.deadSound=ALIENDEATH

        keys=pygame.key.get_pressed()

    def move(self,keys):
        if keys[pygame.K_a]:
            if self.rect.x>=0:
                self.rect=self.rect.move(-self.speed,0)
        if keys[pygame.K_d]:
            if self.rect.x <= WIDTH - self.rect.width - 20:
                self.rect=self.rect.move(self.speed,0)
    def draw(self,screen):
        screen.blit(self.sprite, self.rect)