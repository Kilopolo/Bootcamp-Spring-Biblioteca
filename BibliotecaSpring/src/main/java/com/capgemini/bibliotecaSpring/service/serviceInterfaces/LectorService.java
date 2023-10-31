package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.time.LocalDate;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface LectorService extends ServiceS<Lector> {


	public void devolver(long id, LocalDate fechaDevuelto);

<<<<<<< Updated upstream
	public void prestar(long id, LocalDate fechaAct,Copia copia);

	void multar(long idLector, int diasRetraso);

=======
>>>>>>> Stashed changes
}
