package br.edu.ifsc.clima.application.menu.options;

import br.edu.ifsc.clima.application.services.WeatherApiService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Configuracoes implements WeatherMenuStrategy {
    @Override
    public void printReturn() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("======== CONFIGURAÇÕES ========");
            System.out.println("1. Buscar por Cidade e Estado");
            System.out.println("2. Buscar por woeid");
            System.out.println("0. Sair");
            System.out.println("===============================");
            System.out.print("Digite o número da opção desejada: ");
            escolha = scanner.nextInt();
            int finalEscolha = escolha;

            WeatherApiService weatherApiService = WeatherApiService.getInstance();
            if (escolha == 1) weatherApiService.setWoeid(false);
            if (escolha == 2) weatherApiService.setWoeid(true);
        } while (escolha != 0);
    }

    @Override
    public int getMenuPosition() {
        return 5;
    }
}
