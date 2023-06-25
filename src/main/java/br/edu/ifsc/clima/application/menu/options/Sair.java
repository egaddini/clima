package br.edu.ifsc.clima.application.menu.options;

import org.springframework.stereotype.Component;

@Component
public class Sair implements WeatherMenuStrategy {
    @Override
    public void printReturn() {
        System.out.println("Opção 5 selecionada - Sair");
        System.out.println("Até mais :D");
    }

    @Override
    public int getMenuPosition() {
        return 0;
    }
}
