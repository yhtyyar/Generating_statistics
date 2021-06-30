package controller;

import repository.SaxParserGetAllAddressRepository;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateAddressController {

    private final SaxParserGetAllAddressRepository saxParserDuplicateAddressRepository;
    private static final List<String> addressList = new ArrayList<>();

    public DuplicateAddressController(SaxParserGetAllAddressRepository saxParserDuplicateAddressRepository) {

        this.saxParserDuplicateAddressRepository = saxParserDuplicateAddressRepository;
    }


    public void getDuplicateEntries() {

        addressList.addAll(saxParserDuplicateAddressRepository.getAllInList());

        String[] array = new String[addressList.size()];
        addressList.toArray(array);

        Set<String> allItems = new HashSet<>();

        List<String> duplicates = Arrays.stream(array)
                .filter(n -> {
                    // при добавлении в HashSet одинаковых значений вернет false
                    if (!allItems.add(n)) {

                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());

        Set<String> resultDuplicates = new HashSet<>(duplicates);

        int copy;

        for (String result : resultDuplicates) {
            copy = 0;

            for (String str : duplicates) {
                if (str.equals(result)) {
                    copy++;
                }
            }

            System.out.println(result + " | Количество повторений:" + copy);
        }

    }

    @Override
    public int hashCode() {

        if (addressList == null) {
            return 0;
        }

        int result = 31;

        for (String element : addressList) {

            result = 31 * result + (element == null ? 0 : element.hashCode());
        }

        return result;
    }

}
