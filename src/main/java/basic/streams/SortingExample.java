package basic.streams;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SortingExample {

    public static void main(String[] args) {
        List<Period> periods = buildPeriods();
        periods.forEach(period-> System.out.println(period.getInstallment() + " - " + period.getCreatedAt()));

        System.out.println("---");

        periods.stream()
                .sorted(comparing(Period::getCreatedAt).reversed())
                .map(period -> period.getInstallment() + " - " + period.getCreatedAt())
                .forEach(System.out::println);

    }

    public static List<Period> buildPeriods() {
        List<Period> periods = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Period period = new Period(LocalDateTime.now(), i+1);
            periods.add(period);

            if(i % 2 == 0) {
                Period period2 = new Period(LocalDateTime.now().plusDays(1), i+1);
                periods.add(period2);
            }
        }

        return periods;
    }

    static class Period {
        private LocalDateTime createdAt;
        private Integer installment;

        public Period(LocalDateTime createdAt, Integer installment) {
            this.createdAt = createdAt;
            this.installment = installment;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public Integer getInstallment() {
            return installment;
        }
    }
}
