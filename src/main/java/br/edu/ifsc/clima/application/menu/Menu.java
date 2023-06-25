package br.edu.ifsc.clima.application.menu;

import br.edu.ifsc.clima.application.menu.options.WeatherMenuStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    private List<WeatherMenuStrategy> weatherList;
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("======== MENU DO CLIMA ========");
            System.out.println("1. Consultar clima atual");
            System.out.println("2. Previsão de Amanhã");
            System.out.println("3. Previsão dos próximos dias");
            System.out.println("4. Previão dos próximos dias de chuva");
            System.out.println("5. Configurações");
            System.out.println("0. Sair");
            System.out.println("===============================");

            System.out.print("Digite o número da opção desejada: ");

            escolha = scanner.nextInt();
            int finalEscolha = escolha;

            Optional<WeatherMenuStrategy> weather = weatherList.stream().filter(i -> i.getMenuPosition() == finalEscolha).findFirst();
            if (weather.isPresent()) {
                weather.get().printReturn();
            } else {
                System.out.println("Opção inválida! Por favor, escolha novamente.");
            }
        } while (escolha != 0);
        scanner.close();

    }

}

