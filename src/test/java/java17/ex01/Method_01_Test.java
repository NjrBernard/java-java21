package java17.ex01;

import java.util.List;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

import static org.junit.Assert.assertEquals;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        default Integer sumAge() {
            List<Person> listePersonnes = findAll();
            Integer somme = 0;
            for (Person person : listePersonnes) {
                somme += person.getAge();
            }
            return somme;
        }
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }

    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoA.sumAge();

        assertEquals(210, result);
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoB.sumAge();

        assertEquals(5050, result);

    }
}
