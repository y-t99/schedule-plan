package cn.yuanyuan.sp.foreground.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class HistoryControllerTest {

    @Test
    void test() {
        List<String> pnsns = new ArrayList<String>() {
            {
                add("开心,难过,压力");
                add("开心,压力");
                add("开心,绝望");
                add("开心,难受");
                add("难受,无力");
                add("无力,绝望");
                add("无力,难受");
            }
        };
        Map<String, Long> pnsnsCount = pnsns.stream()
                .map(pnsn -> pnsn.split(","))
                .flatMap(Stream::of)
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        List<Map.Entry<String, Long>> sordedPnsns = pnsnsCount.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        if (sordedPnsns.size() > 3) {
            sordedPnsns = sordedPnsns.subList(sordedPnsns.size() - 3, sordedPnsns.size());
        }
        List<String> top3 = new ArrayList<>();
        sordedPnsns.forEach(e->top3.add(e.getKey()));
        Collections.reverse(top3);
        String[] top3Result = new String[top3.size()];
        for (int i = 0; i < top3Result.length; i++) {
            top3Result[i] = top3.get(i);
        }
        for (String s:
             top3Result) {
            System.out.println(s);
        }
    }

}
