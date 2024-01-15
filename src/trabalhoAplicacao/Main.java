package trabalhoAplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Dados: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário Basse: ");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos possui:  ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor Por Hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Calcular renda por mês e ano (MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda em " + mesEano + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		sc.close();

	}

}
